﻿using System;
using System.ComponentModel;
using System.Windows;


namespace EHealth.ClientApplication.ViewModels
{


    /// <summary>
    /// 
    /// </summary>
    public class MeasureBloodPressureViewModel : INotifyPropertyChanged
    {


        #region INotifyPropertyChanged Members

        public event PropertyChangedEventHandler PropertyChanged;

        protected void SendPropertyChanged(string propertyName)
        {
            if (this.PropertyChanged != null)
                this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
        }

        #endregion


        aladdinService.Task ActiveTask;
        string _SystolicBloodPressureText = "";

        public string SystolicBloodPressureText
        {
            get { return _SystolicBloodPressureText; }
            set
            {
                _SystolicBloodPressureText = value;
                this.SendPropertyChanged("SystolicBloodPressureText");
                this.SendPropertyChanged("SystolicBloodPressure");
            }
        }

        public double? SystolicBloodPressure
        {
            get
            {
                double result;
                bool ok = double.TryParse(this.SystolicBloodPressureText, out result);
                if (ok)
                    return result;
                return null;
            }
        }

        string _DiastolicBloodPressureText = "";

        public string DiastolicBloodPressureText
        {
            get { return _DiastolicBloodPressureText; }
            set
            {
                _DiastolicBloodPressureText = value;
                this.SendPropertyChanged("DiastolicBloodPressureText");
                this.SendPropertyChanged("Weight");
            }
        }

        public double? DiastolicBloodPressure
        {
            get
            {
                double result;
                bool ok = double.TryParse(this.DiastolicBloodPressureText, out result);
                if (ok)
                    return result;
                return null;
            }
        }


        /// <summary>
        /// 
        /// </summary>
        /// <param name="activeTask"></param>
        public MeasureBloodPressureViewModel(aladdinService.Task activeTask)
        {
            this.ActiveTask = activeTask;
        }


        /// <summary>
        /// 
        /// </summary>
        internal void SendMeasurements()
        {
            aladdinService.StorageComponentImplService sc = new aladdinService.StorageComponentImplService();
            aladdinService.SystemParameter measurementType = new aladdinService.SystemParameter();
            aladdinService.OperationResult res1 = new aladdinService.OperationResult();
            aladdinService.OperationResult res2 = new aladdinService.OperationResult();

            if (this.DiastolicBloodPressure.HasValue)
            {
                aladdinService.Measurement diastolicBP = new aladdinService.Measurement();
                diastolicBP.DateTime = App.getTaskById(this.ActiveTask.ID).DateTimeAssigned; // System.DateTime.Now;
                diastolicBP.TaskID = this.ActiveTask.ID;

                measurementType = new aladdinService.SystemParameter();
                measurementType.Code = Convert.ToString((int)Config.MeasurementTypeEnum.DiastolicBloodPressure);
                measurementType.Description = "Diastolic BP";
                
                diastolicBP.Type = measurementType;
                diastolicBP.Value = this.DiastolicBloodPressure.Value;
                diastolicBP.Units = "mmHg";
                diastolicBP.LowerLimitSpecified = false;
                diastolicBP.UpperLimitSpecified = false;

                aladdinService.Measurement[] diastolicBPData = new aladdinService.Measurement[] { diastolicBP };
                res1 = sc.StoreMeasurements(diastolicBPData, App.CurrentUserID);
            }

            if (this.SystolicBloodPressure.HasValue)
            {
                aladdinService.Measurement systolicBP = new aladdinService.Measurement();
                systolicBP.DateTime = App.getTaskById(this.ActiveTask.ID).DateTimeAssigned; // System.DateTime.Now;
                systolicBP.TaskID = this.ActiveTask.ID;

                measurementType = new aladdinService.SystemParameter();
                measurementType.Code = Convert.ToString((int)Config.MeasurementTypeEnum.SystolicBloodPressure);
                measurementType.Description = "Systolic BP";
                
                systolicBP.Type = measurementType;
                systolicBP.Value = this.SystolicBloodPressure.Value;
                systolicBP.Units = "mmHg";
                systolicBP.LowerLimitSpecified = false;
                systolicBP.UpperLimitSpecified = false;

                aladdinService.Measurement[] systolicBPData = new aladdinService.Measurement[] { systolicBP };
                res2 = sc.StoreMeasurements(systolicBPData, App.CurrentUserID);
            }

            if (res1.Status == 1 && res2.Status == 1)
            {
                aladdinService.OperationResult taskChangeStatus = sc.ChangeTaskStatus(Convert.ToInt32(this.ActiveTask.ID), (int)Config.TaskStatusEnum.Completed, App.CurrentUserID);
            }

            AppCommands.MoveToPageCommand.Execute("MyTasksPage", null);
        }


        // For Systolic BP: 60-250 mmHg
        // For Diastolic BP: 30-140 mmHg
        internal bool CanSendMeasurements()
        {
            int sysMin = 60;
            int sysMax = 250;
            int diaMin = 30;
            int diaMax = 140;

            try
            {
                sysMin = Convert.ToInt32( Config.PROPERTIES_DICTIONARY[Config.PROPERTY_BLOOD_SISTOLIC_MIN] );
                sysMax = Convert.ToInt32(Config.PROPERTIES_DICTIONARY[Config.PROPERTY_BLOOD_SISTOLIC_MAX]);
                diaMin = Convert.ToInt32(Config.PROPERTIES_DICTIONARY[Config.PROPERTY_BLOOD_DIASTOLIC_MIN]);
                diaMax = Convert.ToInt32(Config.PROPERTIES_DICTIONARY[Config.PROPERTY_BLOOD_DIASTOLIC_MAX]);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message, Config.APP_NAME, MessageBoxButton.OK, MessageBoxImage.Error);
            }

            return (this.SystolicBloodPressure >= sysMin && this.SystolicBloodPressure <= sysMax
                    && this.DiastolicBloodPressure >= diaMin && this.DiastolicBloodPressure <= diaMax);
        }


    }


}

package eu.ehealth.ws_client.xsd;

import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>
 * Clase Java para Warning complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warning">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeOfWarning" type="{http://aladdin-project.eu/xsd}SystemParameter" minOccurs="0"/>
 *         &lt;element name="DateTimeOfWarning" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Effect" type="{http://aladdin-project.eu/xsd}SystemParameter" minOccurs="0"/>
 *         &lt;element name="Indicator" type="{http://aladdin-project.eu/xsd}SystemParameter" minOccurs="0"/>
 *         &lt;element name="RiskLevel" type="{http://aladdin-project.eu/xsd}SystemParameter" minOccurs="0"/>
 *         &lt;element name="JustificationText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmergencyLevel" type="{http://aladdin-project.eu/xsd}SystemParameter" minOccurs="0"/>
 *         &lt;element name="Patient" type="{http://aladdin-project.eu/xsd}Patient" minOccurs="0"/>
 *         &lt;element name="Delivered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warning", propOrder = { "id", "typeOfWarning",
		"dateTimeOfWarning", "effect", "indicator", "riskLevel",
		"justificationText", "emergencyLevel", "patient", "delivered" })
public class Warning
{


	@XmlElement(name = "ID")
	protected String id;
	@XmlElement(name = "TypeOfWarning")
	protected SystemParameter typeOfWarning;
	@XmlElement(name = "DateTimeOfWarning")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dateTimeOfWarning;
	@XmlElement(name = "Effect")
	protected SystemParameter effect;
	@XmlElement(name = "Indicator")
	protected SystemParameter indicator;
	@XmlElement(name = "RiskLevel")
	protected SystemParameter riskLevel;
	@XmlElement(name = "JustificationText")
	protected String justificationText;
	@XmlElement(name = "EmergencyLevel")
	protected SystemParameter emergencyLevel;
	@XmlElement(name = "Patient")
	protected Patient patient;
	@XmlElement(name = "Delivered")
	protected Boolean delivered;


	/**
	 * Obtiene el valor de la propiedad id.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getID()
	{
		return id;
	}


	/**
	 * Define el valor de la propiedad id.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setID(String value)
	{
		this.id = value;
	}


	/**
	 * Obtiene el valor de la propiedad typeOfWarning.
	 * 
	 * @return possible object is {@link SystemParameter }
	 * 
	 */
	public SystemParameter getTypeOfWarning()
	{
		return typeOfWarning;
	}


	/**
	 * Define el valor de la propiedad typeOfWarning.
	 * 
	 * @param value allowed object is {@link SystemParameter }
	 * 
	 */
	public void setTypeOfWarning(SystemParameter value)
	{
		this.typeOfWarning = value;
	}


	/**
	 * Obtiene el valor de la propiedad dateTimeOfWarning.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDateTimeOfWarning()
	{
		return dateTimeOfWarning;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public GregorianCalendar getDateTimeOfWarningCalendar()
	{
		return dateTimeOfWarning.toGregorianCalendar();
	}


	/**
	 * Define el valor de la propiedad dateTimeOfWarning.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateTimeOfWarning(XMLGregorianCalendar value)
	{
		this.dateTimeOfWarning = value;
	}


	/**
	 * Obtiene el valor de la propiedad effect.
	 * 
	 * @return possible object is {@link SystemParameter }
	 * 
	 */
	public SystemParameter getEffect()
	{
		return effect;
	}


	/**
	 * Define el valor de la propiedad effect.
	 * 
	 * @param value allowed object is {@link SystemParameter }
	 * 
	 */
	public void setEffect(SystemParameter value)
	{
		this.effect = value;
	}


	/**
	 * Obtiene el valor de la propiedad indicator.
	 * 
	 * @return possible object is {@link SystemParameter }
	 * 
	 */
	public SystemParameter getIndicator()
	{
		return indicator;
	}


	/**
	 * Define el valor de la propiedad indicator.
	 * 
	 * @param value allowed object is {@link SystemParameter }
	 * 
	 */
	public void setIndicator(SystemParameter value)
	{
		this.indicator = value;
	}


	/**
	 * Obtiene el valor de la propiedad riskLevel.
	 * 
	 * @return possible object is {@link SystemParameter }
	 * 
	 */
	public SystemParameter getRiskLevel()
	{
		return riskLevel;
	}


	/**
	 * Define el valor de la propiedad riskLevel.
	 * 
	 * @param value allowed object is {@link SystemParameter }
	 * 
	 */
	public void setRiskLevel(SystemParameter value)
	{
		this.riskLevel = value;
	}


	/**
	 * Obtiene el valor de la propiedad justificationText.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJustificationText()
	{
		return justificationText;
	}


	/**
	 * Define el valor de la propiedad justificationText.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setJustificationText(String value)
	{
		this.justificationText = value;
	}


	/**
	 * Obtiene el valor de la propiedad emergencyLevel.
	 * 
	 * @return possible object is {@link SystemParameter }
	 * 
	 */
	public SystemParameter getEmergencyLevel()
	{
		return emergencyLevel;
	}


	/**
	 * Define el valor de la propiedad emergencyLevel.
	 * 
	 * @param value allowed object is {@link SystemParameter }
	 * 
	 */
	public void setEmergencyLevel(SystemParameter value)
	{
		this.emergencyLevel = value;
	}


	/**
	 * Obtiene el valor de la propiedad patient.
	 * 
	 * @return possible object is {@link Patient }
	 * 
	 */
	public Patient getPatient()
	{
		return patient;
	}


	/**
	 * Define el valor de la propiedad patient.
	 * 
	 * @param value allowed object is {@link Patient }
	 * 
	 */
	public void setPatient(Patient value)
	{
		this.patient = value;
	}


	/**
	 * Obtiene el valor de la propiedad delivered.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isDelivered()
	{
		return delivered;
	}


	/**
	 * Define el valor de la propiedad delivered.
	 * 
	 * @param value allowed object is {@link Boolean }
	 * 
	 */
	public void setDelivered(Boolean value)
	{
		this.delivered = value;
	}

}

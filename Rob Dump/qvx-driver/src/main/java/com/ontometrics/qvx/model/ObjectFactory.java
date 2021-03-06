
package com.ontometrics.qvx.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ontometrics.qvx.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ontometrics.qvx.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FieldAttributes }
     * 
     */
    public FieldAttributes createFieldAttributes() {
        return new FieldAttributes();
    }

    /**
     * Create an instance of {@link QvxTableHeader }
     * 
     */
    public QvxTableHeader createQvxTableHeader() {
        return new QvxTableHeader();
    }

    /**
     * Create an instance of {@link QvxTableHeader.Fields }
     * 
     */
    public QvxTableHeader.Fields createQvxTableHeaderFields() {
        return new QvxTableHeader.Fields();
    }

    /**
     * Create an instance of {@link QvxTableHeader.Fields.QvxFieldHeader }
     * 
     */
    public QvxTableHeader.Fields.QvxFieldHeader createQvxTableHeaderFieldsQvxFieldHeader() {
        return new QvxTableHeader.Fields.QvxFieldHeader();
    }

}

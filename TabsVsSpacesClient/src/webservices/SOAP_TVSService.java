/**
 * SOAP_TVSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public interface SOAP_TVSService extends javax.xml.rpc.Service {
    public java.lang.String getSOAP_TVSAddress();

    public webservices.SOAP_TVS getSOAP_TVS() throws javax.xml.rpc.ServiceException;

    public webservices.SOAP_TVS getSOAP_TVS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

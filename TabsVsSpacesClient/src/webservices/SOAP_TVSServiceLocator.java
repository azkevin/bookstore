/**
 * SOAP_TVSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public class SOAP_TVSServiceLocator extends org.apache.axis.client.Service implements webservices.SOAP_TVSService {

    public SOAP_TVSServiceLocator() {
    }


    public SOAP_TVSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOAP_TVSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOAP_TVS
    private java.lang.String SOAP_TVS_address = "http://localhost:8080/TabsVsSpaces/services/SOAP_TVS";

    public java.lang.String getSOAP_TVSAddress() {
        return SOAP_TVS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOAP_TVSWSDDServiceName = "SOAP_TVS";

    public java.lang.String getSOAP_TVSWSDDServiceName() {
        return SOAP_TVSWSDDServiceName;
    }

    public void setSOAP_TVSWSDDServiceName(java.lang.String name) {
        SOAP_TVSWSDDServiceName = name;
    }

    public webservices.SOAP_TVS getSOAP_TVS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOAP_TVS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAP_TVS(endpoint);
    }

    public webservices.SOAP_TVS getSOAP_TVS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webservices.SOAP_TVSSoapBindingStub _stub = new webservices.SOAP_TVSSoapBindingStub(portAddress, this);
            _stub.setPortName(getSOAP_TVSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOAP_TVSEndpointAddress(java.lang.String address) {
        SOAP_TVS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webservices.SOAP_TVS.class.isAssignableFrom(serviceEndpointInterface)) {
                webservices.SOAP_TVSSoapBindingStub _stub = new webservices.SOAP_TVSSoapBindingStub(new java.net.URL(SOAP_TVS_address), this);
                _stub.setPortName(getSOAP_TVSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SOAP_TVS".equals(inputPortName)) {
            return getSOAP_TVS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices", "SOAP_TVSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices", "SOAP_TVS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOAP_TVS".equals(portName)) {
            setSOAP_TVSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

package webservices;

public class SOAP_TVSProxy implements webservices.SOAP_TVS {
  private String _endpoint = null;
  private webservices.SOAP_TVS sOAP_TVS = null;
  
  public SOAP_TVSProxy() {
    _initSOAP_TVSProxy();
  }
  
  public SOAP_TVSProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAP_TVSProxy();
  }
  
  private void _initSOAP_TVSProxy() {
    try {
      sOAP_TVS = (new webservices.SOAP_TVSServiceLocator()).getSOAP_TVS();
      if (sOAP_TVS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAP_TVS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAP_TVS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAP_TVS != null)
      ((javax.xml.rpc.Stub)sOAP_TVS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservices.SOAP_TVS getSOAP_TVS() {
    if (sOAP_TVS == null)
      _initSOAP_TVSProxy();
    return sOAP_TVS;
  }
  
  public java.lang.String getProductInfo(java.lang.String productId) throws java.rmi.RemoteException{
    if (sOAP_TVS == null)
      _initSOAP_TVSProxy();
    return sOAP_TVS.getProductInfo(productId);
  }
  
  
}
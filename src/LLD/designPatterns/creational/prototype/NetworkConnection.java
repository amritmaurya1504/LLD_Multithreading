package LLD.designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/*
✅ Prototype Design Pattern Example: NetworkConnection

- This class simulates a costly object (e.g., connecting to a network and loading important data).
- Instead of creating and initializing a new object every time (which includes delay), we clone an existing, initialized object.
- This saves time and resources.
*/

public class NetworkConnection implements Cloneable{
    private String ip;
    private String impData;
    private List<String> domains = new ArrayList<>();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImpData() {
        return impData;
    }

    public void setImpData(String impData) {
        this.impData = impData;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public void loadImpData() throws InterruptedException {
        this.impData = "Very Very Importand Data!!!";
        domains.add("www.programmingwithamrit.com");
        domains.add("www.google.com");
        domains.add("www.pwa.com");
        domains.add("www.youtube.com");

        Thread.sleep(2000);
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", impData='" + impData + '\'' +
                ", domains=" + domains +
                '}';
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp(this.ip);
        networkConnection.setImpData(this.impData);

        for (String d : this.getDomains()){
            networkConnection.getDomains().add(d);
        }

        return networkConnection;
    }
}

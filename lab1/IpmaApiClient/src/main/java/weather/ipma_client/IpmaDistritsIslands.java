package weather.ipma_client;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IpmaDistritsIslands {
    @SerializedName("data")
    @Expose
    private List<IpmaDistritsIslands> data = null;

    @SerializedName("globalIdLocal")
    @Expose
    private Integer globalIdLocal;

    @SerializedName("local")
    @Expose
    private String local;

    public List<IpmaDistritsIslands> getData() {
        return data;
    }

    public void setData(List<IpmaDistritsIslands> data) {
        this.data = data;
    }

    public Integer getGlobalIdLocal() {
        return globalIdLocal;
    }

    public void setGlobalIdLocal(Integer globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}

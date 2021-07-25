package org.acme.model;

public class SamplePojo {

    private int id;

    private String data;

    public SamplePojo(int id,String data)
    {
        this.id =id;
        this.data=data;
    }

    public int getId()
    {
        return id;
    }

    public String getData()
    {
        return data;
    }
}

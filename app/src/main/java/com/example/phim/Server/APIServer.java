package com.example.phim.Server;

public class APIServer {
    //URL  folder chứa API
    private static String base_url = "https://vhproject.000webhostapp.com/api/";

    public static DataServer getServer()
    {
        return Retrofit2.getClient(base_url).create(DataServer.class);
    }
}

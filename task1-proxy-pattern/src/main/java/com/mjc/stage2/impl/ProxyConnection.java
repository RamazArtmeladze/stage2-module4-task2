package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    @Override
    public void close() {
        if (!realConnection.isClosed()) {
            ConnectionPool.getInstance().releaseConnection(this);
        }
    }
    public void reallyClose() {
        realConnection.close();
    }
    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }
}

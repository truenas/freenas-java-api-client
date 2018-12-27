package org.freenas.client.websockets;

import java.util.concurrent.Callable;

public interface ReceivedMessage<V>  {

    public  V call(String message);
}

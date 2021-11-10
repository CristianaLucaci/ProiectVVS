package webserver;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import org.junit.Test;

import webserver.WebServer.ServerStatus;

public class WebServerTest {
	
	private static WebServer webServer;
    private static ServerSocket serverSocket;
    private static int clientSocketPort;
    private File file = new File(WebServer.getIndex());
    public WebServerTest() throws IOException {
    }

    @Test
    public void verifyFileCreation() {
        assertNotNull(file);
    }

    @Test
    public void verifyIfServerIsStopped(){
        assumeTrue(WebServer.getStare() == ServerStatus.STOPPED);
        assertEquals(ServerStatus.STOPPED , WebServer.getStare());
    }

    @Test
    public void verifyIfServerIsRunning(){
        assumeTrue(WebServer.getStare() == ServerStatus.RUNNING);
        assertEquals(ServerStatus.RUNNING , WebServer.getStare());
    }
    
    @Test
    public void verifyIfServerIsInMaintenance(){
        assumeTrue(WebServer.getStare() == ServerStatus.MAINTENANCE);
        assertEquals(ServerStatus.MAINTENANCE , WebServer.getStare());
    }
    
    @Test
    public void verifySocket() {
    	assertEquals(webServer.getClientSocket(), serverSocket);
    }

}

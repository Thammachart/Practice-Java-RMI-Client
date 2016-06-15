package org.rmi.clients;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;

import org.rmi.components.ComputeRemoteInterface;
import org.rmi.components.Task;

public class MainClass {
    public static void main(String args[]) {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry();

            ComputeRemoteInterface compute = (ComputeRemoteInterface) registry.lookup(name);

            Task<BigDecimal> task = new FactorialTask(5);
            System.out.println("Preparing Task...");
            BigDecimal result = compute.executeTask(task);
            System.out.println(result);
        } catch(Exception e) {
            System.err.println("Exception: ");
            e.printStackTrace();
        }
    }
}

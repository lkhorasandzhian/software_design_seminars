package org.example;

public interface IWorkloadable {
    default void sayWorkload() {
        System.out.println("My workload is 0% of all");
    }
}

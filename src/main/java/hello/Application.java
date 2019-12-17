package hello;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Objects;

public class Application {
	
	public static void main(String[] args) {
	    int no_of_random_items = Integer.valueOf(args[0]);

        if(args.length < 2){
            System.out.println("Mention the type of algorithm either 'classic' or 'fast' as second parameter");
            System.exit(-1);
        }

        double initial_free_memory = print_memory_at("START");
        if (args[1].equals("classic"))
            SetMembershipTest.testClassicMembership(no_of_random_items);
        else if (args[1].equals("fast"))
            SetMembershipTest.testScalableMembership(no_of_random_items);
        else {
            System.out.println("Mention the type of algorithm either 'classic' or 'fast' as second parameter");
            System.exit(-1);
        }

        double final_free_memory = print_memory_at("END");
        System.out.println("Memory utilised: " + (initial_free_memory - final_free_memory) + "MB");
    }

    private static double print_memory_at(final String content) {
        System.out.println("--------------------" + content + "----------------------------");
        double free_memory = print_jvm_heap_size();
        System.out.println("--------------------------------------------------------");
        return free_memory;
    }

    private static double print_jvm_heap_size() {
        Runtime rt = Runtime.getRuntime();

        double megs = 1024 * 1024;
        double totalMem = Math.ceil(rt.totalMemory() / megs);
        double maxMem = Math.ceil(rt.maxMemory() / megs);
        double freeMem = Math.ceil(rt.freeMemory() /megs);

        System.out.println ("Total Memory: " + totalMem + " MB");
        System.out.println ("Max Memory:   " + maxMem   + " MB");
        System.out.println ("Free Memory:  " + freeMem  + " MB");

        return freeMem;
    }
}

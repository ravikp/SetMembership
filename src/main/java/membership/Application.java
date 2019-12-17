package membership;

import membership.tester.*;

public class Application {

    public static final String CLASSIC = "classic";
    public static final String BLOOM = "bloom";
    private static final String CUCKOO = "cuckoo";

    public static void main(String[] args) {
	    int no_of_random_items = Integer.valueOf(args[0]);

        if(args.length < 2){
            System.out.println("Mention the type of algorithm either 'classic' or 'fast' as second parameter");
            System.exit(-1);
        }

        MembershipTester membershipTester = createMembershipTester(args[1]);
        membershipTester.test(no_of_random_items);
    }

    private static MembershipTester createMembershipTester(String membershipTesterType) {
        if (membershipTesterType.equals(CLASSIC))
            return new ClassicMembershipTester();
        if (membershipTesterType.equals(BLOOM))
            return new BloomMembershipTester();
        if(membershipTesterType.equals(CUCKOO))
            return new CuckooMembershipTester();
        throw new RuntimeException("Unknown type of algorithm");
    }
}

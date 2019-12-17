package membership.tester;

import membership.MembershipTester;
import membership.container.CuckooContainer;

public class CuckooMembershipTester extends MembershipTester {

    @Override
    public void test(int numberOfItems) {
        double falsePositiveRate = 10E-6;
        runTests(new CuckooContainer(numberOfItems, falsePositiveRate));
    }
}

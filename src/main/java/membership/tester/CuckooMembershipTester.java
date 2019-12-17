package membership.tester;

import membership.MembershipTester;
import membership.SetMembershipTest;
import membership.container.CuckooContainer;

public class CuckooMembershipTester implements MembershipTester {
    @Override
    public void test(int numberOfItems) {
        double falsePositiveRate = 10E-6;
        final CuckooContainer container = new CuckooContainer(numberOfItems, falsePositiveRate);
        SetMembershipTest.test(container);
    }
}

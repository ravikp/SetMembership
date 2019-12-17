package membership.tester;

import membership.MembershipTester;
import membership.SetMembershipTest;
import membership.container.CuckooContainer;

public class CuckooMembershipTester implements MembershipTester {
    @Override
    public void test(int numberOfItems) {
        final CuckooContainer container = new CuckooContainer(numberOfItems);
        SetMembershipTest.test(container);
    }
}

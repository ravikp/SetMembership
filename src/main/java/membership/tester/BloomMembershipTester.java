package membership.tester;

import membership.MembershipTester;
import membership.container.BloomContainer;

public class BloomMembershipTester extends MembershipTester {

    @Override
    public void test(int numberOfItems) {
        runTests(new BloomContainer(numberOfItems, 10E-6));
    }

}

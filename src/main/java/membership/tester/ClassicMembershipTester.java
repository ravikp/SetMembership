package membership.tester;

import membership.MembershipTester;
import membership.container.ClassicMembershipContainer;

public class ClassicMembershipTester extends MembershipTester {

    @Override
    public void test(int numberOfItems) {
        runTests(new ClassicMembershipContainer(numberOfItems));
    }
}

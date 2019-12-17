package membership;

import membership.container.Container;

public abstract class MembershipTester {
    public abstract void test(int numberOfItems);

    protected final void runTests(Container container) {
        SetMembershipTest.test(container);
    }
}

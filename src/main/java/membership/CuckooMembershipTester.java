package membership;

public class CuckooMembershipTester implements MembershipTester {
    @Override
    public void test(int numberOfItems) {
        final CuckooContainer container = new CuckooContainer(numberOfItems);
        SetMembershipTest.test(container);
    }
}

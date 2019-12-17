package membership;

public class BloomMembershipTester implements MembershipTester {

    @Override
    public void test(int numberOfItems) {
        final BloomContainer container = new BloomContainer(numberOfItems, 10E-6);
        SetMembershipTest.test(container);
    }
}

package membership;

public class ClassicMembershipTester implements MembershipTester {

    @Override
    public void test(int numberOfItems) {
        final ClassicMembershipContainer container = new ClassicMembershipContainer(numberOfItems);
        SetMembershipTest.test(container);
    }
}

package lab5.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({TestAddRemoveBooks.class, 
				TestAddRemoveMembers.class,
				TestFindClassString.class,
				TestBorrowBooks.class,
				TestNotAvailableBook.class,
				TestRemoveMemberWithBooks.class,
				TestController.class,
				MemberAddRemoveBook.class,
				BookCantFindBook.class,
				MemberBorrowLimitReached.class,
				SingletonTestSingleton.class,
				TestFactoryTypes.class})
public class AllTests {
    // No need for test methods here; the suite will run the included classes
}


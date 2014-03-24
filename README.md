JVM-Cucumber-Parallel-Tests
===========================

A prototype for parallel JVM-Cucumber tests

The Idea
JVM Cucumber tests can be run in parallel using executor service of the Spring framework.
The idea which is used here is to run different test runners in multiple threads.

Simply run the test runners with customised ParallelSuite class instead of Cucumber class
using @RunWith(ParallelSuite.class)

and @Suite.SuiteClasses({GroupATestsRunner.class, GroupBTestsRunner.class, GroupCTestsRunner.class, GroupDTestsRunner.class, GroupETestsRunner.class })





# Assignement - Testing the FERIT website

For this assignement, I've selected the example of testing a website of choice. The website of choice is the official
FERIT website, serving as a utility to students and faculty alike.

In the tests provided within the project, we've tested some of the basic navigation the site holds, but we've also
pointed out some of the crucial things which lack and/or do not work properly.

The test cases are the following:

* Open up the site, check the header with the navigation exists -> this test serves as a basis, to check the website
  can load properly.

* Find the subject which this assignement is for. -> this test uses the standard navigation throughout a few pages,
  in order to find and scroll to the subject for which this assignement is prepared.

* Break the standard multi-language navigation -> This test serves to verify if the multilanguage navigation works or not.
  If we click on the language banner twice, we'd expect to come to the same link/site from which we originated. This is not
  the case.

* Break the standard multi-language navigation -> This test serves to verify if the multilanguage navigation works or not.
  By clicking three times on the language banner in the top right corner, we can break the entire web site, because it
  will try to show a resource which doesn't exist. This should just change the way the site looks (translate the text)

* Test search a word. This test attempts to search for a keyword "praksa" and looks if there are any results available.
  Usually the site would find some results, but using the "search" icon, we only refresh the page.


Challenges along the way were mostly due to the structure of the site, the DOM and the attributes each of the HTML/DOM elements
is composed of. Nearly all elements in the tests had to be found using XPaths, which is a bad practice, because there were
no IDs, no names, or special class-identifiers we could use to locate them. This resulted in our XPath lookup, which would
break if we change even on layer of elements.

To use the project, simply open it up in **IntelliJ IDEA**, and import it as a **Gradle** project.

We used the Gradle build system here, due to it's simplicity and readability of build-system scripts. And the tests were
written using the JUnit4 test framework, and the Kotlin programming language. Once the project dependency synchronization
is finished, you should be able to navigate to **src > test > kotlin > WebTest** Kotlin file, and right clicking it
should open up a menu, asking you what to do. Once that menu is opened, simply click on the **Run 'WebTest'** option.

In a few moments you should see each of the tests executing, and you should have a few passed tests, as well as a few
failed ones. The failed tests are there to indicate bugs with the website, which the developers should prioritize and
fix accordingly.
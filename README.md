Flower Pot
Create the Flower and Pot classes according to the following specification detailed in the UML diagram below and Javadocs:

Updates (and responses to common Ed questions):

If the pot is empty (or none are alive), averageAge and averageHeight should return -1

maxAge is the maximum age of the flower, if the age goes beyond this, it dies

For clarity, tan^-1 means the inverse tan function (arctan) not 1/tan().

Note that searches for null values in species and colour crierion should work and be able to find flowers in the pot with null values as those attributes

Most Pot tests require the use of insert(), water() and rearrange(), so make sure these methods are working first.

combine() and view() should not include flowers with null colour in the result.

view() method is case insensitive for the colour string

If null is passed as input to the Pot insert() method, return false. (cannot add null)

For the replace() method, if both are null, return 0.

The first hidden testcase is testing the order of the colours in the view() method output is in alphabetical order. See the assignment helpful notes. You need to add the entries into an ArrayList and then sort using a Comparator, or use a TreeMap instead of HashMap. The TreeMap is automatically sorted by key order, unlike HashMap which is unordered.

For replace() and filter(), ensure you don't create a situation where a Flower object is present in multiple pots, or more than once in the same pot.

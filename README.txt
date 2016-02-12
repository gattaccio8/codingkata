#codingkata

My initial approach of course was understand the requirements and I used the sample inputs and outputs:

1 = “I”
5 = “V”
10 = “X”
20 = “XX”
3999 = “MMMCMXCIX”

as acceptance criteria in order to write my first test. Trying to break down the task into smaller tasks
I wrote a test only for numbers going from 1 to 10. I still think this was good starting point for tests
but I suddenly realised that my implementation approach was wrong as I was try to implement rules like:

//When a symbol appears before a larger symbol it is subtracted
//When a symbol appears after a larger symbol it is added
//Don't use the same symbol more than three times in a row

Above approach in my view wasn't wrong but much harder than my final solution. Having a starting table I then
implemented the requirements starting from:

1. Any number greater than 3999 is not supported
2. If the number exist in the table just retrieve it
3. Use a tail recursion to build final result




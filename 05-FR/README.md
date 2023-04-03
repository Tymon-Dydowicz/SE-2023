## **Tymon Dydowicz Artifical Intelligence 151936**
In this file we described the workings of some auction application.\
Kind of a scheme how each element is supposed to work and interact with other elements but without mention of implementation.\
Although the scheme is neat, I think the way the money/item transfer works should be changed due to the lack of security.\
For example:
* Money should be taken when the bid is done, and then either transfered to seller by the system in case of winning\
or returned to the buyer if he was outbid.
<img src="https://www.qgiv.com/blog/wp-content/uploads/2019/07/Bids.png" width="400" height="200" />

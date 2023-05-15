## **Tymon Dydowicz Artifical Intelligence 151936**

### Q&A
Q: How to change the operation of the mock object to verify that the interaction of the
loadExpenses method with the database mock object was correct, i.e. first a connection to the database was
opened (connect), then data was downloaded (queryAll), and finally the connection was terminated (close)?\
A: We can either use verify(mock, times(1)).connect/querryAll/close to check whether those methods were called exactly once but that doesn't ensure that they were performed in this exact order. Better way is to use InOrder class object and call it like: \
InOrder inOrder = inOrder(mock)\
inOrder.verify(mock).connect();\
inOrder.verify(mock).querryAll();\
inOrder.verify(mock).close();\
To ensure that the methods were called in appropriate order.


Q: Does the order of expectations for the same method matched by different arguments matter?\
A: No it doesn't because the expecatation is connected with the argument so it doens't matter in which order we will verify the result\
<img src="https://img.stackshare.io/service/2021/4y634TJm_400x400.jpg" width="200" height="200" />

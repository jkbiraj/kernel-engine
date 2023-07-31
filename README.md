# kernel-engine

kernel engine is the client application which fetch data for multiple virtual device 
from plugin engine.

### Details
- To run the application open KernelEngineApplication file and run main method
- There's implementation of scheduler which requests the data from the client
by http rest client requests for every five seconds for each device.


### Improvement
- There's still scope for improvement in logging, exception handling and unit testing.
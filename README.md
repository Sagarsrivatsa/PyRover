# PyRover
A Rover built on raspberry pi controlled by an android applcation.
Hardware: A raspberry pi,motors and chassis according to the design.
A L293D drives the 60 RPM geared motors which is controlled by the Raspberry pi
Software: An android application whose sources are found in this repository , gradle is not included.
The python file sweepcar.py contains the related code for running the motor , the android app interacts with the raspberry pi through mqtt protocol and the pi is also connected to the Amazon AWS Linux instance for sending the sensor data to the cloud 
Further dev:This can be used as an autonomous rover after implementing few machine learning algo and aneural networks.

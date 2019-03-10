# coding: utf-8
from firebase import firebase
import json
import time
import serial
import threading
import os
import base64
import RPi.GPIO as GPIO
i=0
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
TRIG = 23
ECHO = 24
lf = 19
rf = 16
lb = 26
rb = 20
GPIO.setup(TRIG,GPIO.OUT)
GPIO.setup(ECHO,GPIO.IN)
GPIO.output(TRIG, False)
GPIO.setup(lf,GPIO.OUT)
GPIO.setup(rf,GPIO.OUT)
GPIO.setup(lb,GPIO.OUT)
GPIO.setup(rb,GPIO.OUT)
ser = serial.Serial('/dev/ttyACM6', 9600, timeout=1)
ser.isOpen()

def Straight():
    GPIO.output(rf,False)
    GPIO.output(lf,False)
    GPIO.output(rb,True)
    GPIO.output(lb,True)

def Back():
    GPIO.output(rb,True)
    GPIO.output(lb,True)
    GPIO.output(rf,False)
    GPIO.output(lf,False)
def RightF():
    GPIO.output(rb,False)
    GPIO.output(lb,True)
    GPIO.output(rf,False)
    GPIO.output(lf,False)

def LeftF():
    GPIO.output(rb,True)
    GPIO.output(lb,False)
    GPIO.output(rf,False)
    GPIO.output(lf,False)

def RightB():
    GPIO.output(rb,False)
    GPIO.output(lb,True)
    GPIO.output(rf,False)
    GPIO.output(lf,False)

def LeftB():
    GPIO.output(rb,True)
    GPIO.output(lb,False)
    GPIO.output(rf,False)
    GPIO.output(lf,False)

def Stop():
    GPIO.output(rb,False)
    GPIO.output(lb,False)
    GPIO.output(rf,False)
    GPIO.output(lf,False)

options={
   "1":Straight,
   "2":RightF,
   "3":RightB,
   "4":Back,
   "5":LeftB,
   "6":LeftF,
   "7":Stop
}
firebase_url='https://botnet3-f4eca.firebaseio.com/'
firebase = firebase.FirebaseApplication(firebase_url)

class myThread1(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)

    def run(self):
        while 1:
           result=firebase.get('status/Move',None)
           options[result]()
           print (result)
           if firebase.get('status/Ultrasonic_Status',None):
              print ("on")
              action=Ultra()
              if action=="Get Away":
                 if result!=7 or result!=5 or result!=3 or result!=4:
                    Stop()
           dir= firebase.get('armcam/now',None)
           print (dir)
           ser.write(dir)

class myThread2(threading.Thread):
   def __init__(self):
       threading.Thread.__init__(self)
       time.sleep(0.4)
   def run(self):
       while 1:
          if firebase.get('status/Image',None):
              global i
              i=i+1
              cur_image="image";
              cur_image=cur_image+str(i)+".jpg"
              os.system("fswebcam "+"-r 50*50 "+cur_image)
              time.sleep(0.4)
              try:
                 encoded = base64.b64encode(open(cur_image, "rb").read())
                 time.sleep(0.3)
              except IOError:
                 print("file dose not exist yet")
              os.system("sudo rm "+cur_image)
              firebase.put('image','now',encoded)
          else:
              time.sleep(2)

def Ultra():
    GPIO.output(TRIG, True)
    time.sleep(0.00001)
    GPIO.output(TRIG, False)
    while GPIO.input(ECHO)==0:
       pulse_start = time.time()
    while GPIO.input(ECHO)==1:
       pulse_end = time.time()
    pulse_duration = pulse_end - pulse_start
    distance = pulse_duration * 17150
    distance = round(distance, 2)
    if distance>=1 and distance<=60:
       action="Get Away"
    else:
       action="Everything Good"
    return action

thread1=myThread1()
thread2=myThread1()
thread3=myThread1()
thread4=myThread1()
thread5=myThread1()
thread6=myThread1()
thread7=myThread1()
thread8=myThread1()
thread9=myThread1()
thread10=myThread1()
thread11=myThread1()
thread12=myThread1()
thread13=myThread1()

thread14=myThread2()
thread15=myThread2()
thread15=myThread2()
thread16=myThread2()
thread17=myThread2()



thread1.start()
thread2.start()
thread3.start()
thread4.start()
thread5.start()
thread6.start()
thread7.start()
thread8.start()
thread9.start()
thread10.start()
thread11.start()
thread12.start()
thread13.start()
thread14.start()
thread15.start()
thread16.start()
thread17.start()



while 1:
   pass


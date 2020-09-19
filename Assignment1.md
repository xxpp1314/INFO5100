1. Design a course management system
- Course:
  Data: Name, CourseNumber, MeetingTime, MeetingRoom, ClassSize, WaitingList
  Behaviors: updateCourseInformation, 
 -Student
  Data: Name, loginCredential
  Behaviors: login, search, registeredCourse, dropCourse, inWaitingList
 -Course Management Website
  Data: StudentName, CourseName
  Behaviors: processStudentRegistration, publishCourseInformation
Sequence of invoking behaviors on objects
  Student Rachel;
  Course 

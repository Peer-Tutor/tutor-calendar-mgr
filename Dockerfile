FROM eclipse-temurin:11 as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests -e
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:11
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java" ,"-cp","app:app/lib/*","com.peertutor.TutorCalendarMgr.TutorCalendarMgrApplication"]

# to use for ci cd
# ENTRYPOINT ["java" ,"-cp","app:app/lib/*","com.peertutor.TutorCalendarMgr.TutorCalendarMgrApplication", "-Dspring.profiles.active=docker"]
# -Dspring.profiles.active=aws

# Old
# define base docker image - openjdk:11
# FROM openjdk:11

# metadata
# LABEL maintainer="nadine"

# The WORKDIR command is used to define the working directory of a Docker container at any given time. The command is specified in the Dockerfile.
# Any RUN, CMD, ADD, COPY, or ENTRYPOINT command will be executed in the specified working directory.
# WORKDIR ./app
# copy .jar to docker image
# ADD ./target/ClassRoomSvcs-0.0.1-SNAPSHOT.jar classroomsvc.jar

# command to run when starting docker
# ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "classroomsvc.jar"]
# ENTRYPOINT ["java", "-jar", "classroomsvc.jar"]



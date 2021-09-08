# QuarkusExperiments
This repository will contain experiments related to quarkus and Mandrel Vm.


# KafkaProducerQuarkus
This project uses resteasy reactive to accept post requests and that message is used
by emitter to be put on kafka queue.

References: 
1. https://quarkus.io/guides/resteasy-reactive 
2. https://quarkus.io/blog/reactive-messaging-emitter/

# Quarkus Iot Hub Helper
This project is responsible for using azure iot hub service. It receives messages from
kafka and sends them to iot hub using service client.

References:
1. https://azure.microsoft.com/en-in/services/iot-hub/
2. https://github.com/Azure/azure-iot-sdk-java/tree/master/service/iot-service-samples/pnp-service-sample
3. https://quarkus.io/guides/smallrye-health
4. https://quarkus.io/guides/smallrye-fault-tolerance

# Quarkus Native Kafka Streams
This project is responsible for using kafka streams in native fashion along with
sample transformations of FHIR payloads.

References:
1. https://quarkus.io/guides/kafka-streams
2. https://github.com/apache/camel-quarkus/blob/main/integration-tests/fhir/src/main/resources/application.properties
3. https://camel.apache.org/camel-quarkus/latest/reference/extensions/fhir.html


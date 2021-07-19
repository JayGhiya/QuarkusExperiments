/*
package org.kafka.streams.reflection.fhir;



import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

import java.io.IOException;

public class RuntimeReflectionRegistration implements Feature {

    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access)
    {
        try {
            ClassPath classPath = ClassPath.from(org.hl7.fhir.r4.model.Observation.class.getClassLoader());

            ImmutableSet<ClassPath.ClassInfo> infos = classPath.getTopLevelClassesRecursive("org.hl7.fhir.r4.model");

            infos.stream().iterator().forEachRemaining((e) ->
            {
                try {

                    RuntimeReflection.register(e.load());
                    RuntimeReflection.register(e.load().getDeclaredMethods());

                }
                catch (Exception exception)
                {

                }
            });

            ClassPath classPath2 = ClassPath.from(org.hl7.fhir.utilities.xhtml.CDANarrativeFormat.class.getClassLoader());


            ImmutableSet<ClassPath.ClassInfo> infoPath = classPath2.getTopLevelClassesRecursive("org.hl7.fhir.utilities.xhtml");

            infoPath.stream().iterator().forEachRemaining((e) ->
            {
                try {
                    RuntimeReflection.register(e.load());
                    //RuntimeReflection.register(e.load().getDeclaredMethods());
                    //RuntimeReflection.register(e.load().getMethods());
                }
                catch (Exception exception)
                {

                }

            });



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
*/

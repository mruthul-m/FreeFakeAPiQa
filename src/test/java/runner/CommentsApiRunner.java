package runner;

import com.intuit.karate.junit5.Karate;

public class CommentsApiRunner {
  @Karate.Test
  Karate KarateTest() {
    return Karate.run("classpath:features/commentsapi.feature").relativeTo(getClass());
  }

}

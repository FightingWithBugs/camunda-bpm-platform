/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.spring.test;

import org.camunda.bpm.engine.spring.test.SpringTestHelper;
import org.springframework.test.annotation.DirtiesContext.HierarchyMode;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListener;

/**
 * This is the same as the Spring3Test helper, but it is
 * important to compile the helper against Spring 4 for it to work.
 */
public class Spring4TestHelper implements SpringTestHelper {

  @Override
  public void beforeTestClass(TestContextManager testContextManager) {
    testContextManager.registerTestExecutionListeners(new TestExecutionListener() {

      @Override
      public void prepareTestInstance(TestContext testContext) throws Exception {
      }

      @Override
      public void beforeTestMethod(TestContext testContext) throws Exception {
      }

      @Override
      public void beforeTestClass(TestContext testContext) throws Exception {
      }

      @Override
      public void afterTestMethod(TestContext testContext) throws Exception {
      }

      @Override
      public void afterTestClass(TestContext testContext) throws Exception {
        // ensures that the application context is not cached beyond this test
        testContext.markApplicationContextDirty(HierarchyMode.EXHAUSTIVE);
      }
    });
  }
}

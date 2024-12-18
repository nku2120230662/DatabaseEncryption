//package demo;
//
//public class BenchmarkExample {
//    @State(Scope.Thread)
//    public class BenchmarkExample {
//
//        private long sum;
//
//        @Setup
//        public void setup() {
//            sum = 0;
//        }
//
//        @Benchmark
//        public void testMethod() {
//            for (int i = 0; i < 1000000; i++) {
//                sum += i;
//            }
//        }
//
//        public static void main(String[] args) throws Exception {
//            new Runner(new OptionsBuilder()
//                    .include(BenchmarkExample.class.getSimpleName())
//                    .forks(1)
//                    .build())
//                    .run();
//        }
//    }
//}

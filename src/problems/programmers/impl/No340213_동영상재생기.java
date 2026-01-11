package problems.programmers.impl;

public class No340213_동영상재생기 {
    class Solution1 {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            Time current = Time.from(pos);
            Time videoEnd = Time.from(video_len);
            Time opStart = Time.from(op_start);
            Time opEnd = Time.from(op_end);
            for (String command : commands) {
                current = current.skipOpening(opStart, opEnd);

                if (command.equals("prev")) {
                    current = current.previous();
                } else if (command.equals("next")) {
                    current = current.next(videoEnd);
                }
            }
            return current.skipOpening(opStart, opEnd).toString();
        }

        static class Time implements Comparable<Time> {
            int minutes;
            int seconds;

            private Time(int minutes, int seconds) {
                this.minutes = minutes;
                this.seconds = seconds;
            }

            /**
             * "mm:ss" 형식의 문자열을 Time 타입으로 변환하는 팩토리 메서드
             * 
             * @param time "mm:ss" 형식을 만족하는 문자열
             * @return 해당 시간의 Time
             */
            public static Time from(String time) {
                String[] parts = time.split(":");
                return new Time(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
            }

            /**
             * 10초 전으로 이동합니다. 만약, 10초 미만일 경우 처음 위치로 이동합니다.
             * 
             * @return 10초 미만일 경우 처음 위치 리턴, 10초 미만이 아닐 경우 10초 전 위치 리턴
             */
            public Time previous() {
                int totalSeconds = this.toTotalSeconds();
                totalSeconds -= 10;
                if (totalSeconds < 0) {
                    totalSeconds = 0;
                }
                return new Time(totalSeconds / 60, totalSeconds % 60);
            }

            /**
             * 10초 후로 이동합니다. 남은 시간이 10초 미만일 경우 영상 마지막 위치로 이동
             * 
             * @param end 영상의 마지막 위치
             * @return 남은 시간이 10초 미만일 경우 영상 마지막 위치 리턴, 10초 미만이 아닐 경우 10초 후 위치 리턴
             */
            public Time next(Time end) {
                int totalSeconds = this.toTotalSeconds();
                totalSeconds += 10;
                if (end.toTotalSeconds() < totalSeconds) {
                    return end;
                }
                return new Time(totalSeconds / 60, totalSeconds % 60);
            }

            /**
             * 현재 재생 위치가 오프닝 구간이면 오프닝이 끝나는 위치로 이동
             * 
             * @param start 오프닝 시작 위치
             * @param end   오프닝 끝 위치
             * @return 오프닝 구간인 경우 오프닝 끝 위치 리턴, 아닌 경우 현재 위치 리턴
             */
            public Time skipOpening(Time start, Time end) {
                if (isInRange(start, end)) {
                    return end;
                }
                return this;
            }

            @Override
            public String toString() {
                return String.format("%02d:%02d", this.minutes, this.seconds);
            }

            @Override
            public int compareTo(Time that) {
                return Integer.compare(this.toTotalSeconds(), that.toTotalSeconds());
            }

            /**
             * 현재 시간을 초단위로 바꿔주는 함수. compareTo 때문에 내부적으로 구현
             * 
             * @return totalSeconds
             */
            private int toTotalSeconds() {
                return this.minutes * 60 + this.seconds;
            }

            /**
             * 현재 시간이 주어진 범위 내에 있는지 판단하는 함수
             * 
             * @param start 시작 시간 (inclusive)
             * @param end   끝 시간 (inclusive)
             * @return 범위 내에 있으면 true 리턴, 범위 밖에 있으면 false 리턴
             */
            private boolean isInRange(Time start, Time end) {
                return this.compareTo(start) >= 0 && this.compareTo(end) <= 0;
            }
        }
    }
}

/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2015 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/


import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Problem4A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();

        //Stream.generate(sumPairGenerator(input)).
        // haha
        boolean yes = Stream.generate(scanner::nextInt)
                .limit(1)
                .allMatch(val -> val % 4 == 0);

        if (yes) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    // todo
    static Supplier<LongPair> sumPairGenerator(long val) {
        final long a = 0;
        final long b = val - a;

        return () -> {
            return new LongPair(a, b);
        };
    }

    static class LongPair {
        private final long fst;
        private final long snd;

        public LongPair(long fst, long snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }
}
/*
 WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION
 OF THE SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING,
 REPRODUCTION, REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY,
 DECOMPILATION OR MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE
 AGREEMENT WITH NETCRACKER. 
 
 THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN
 THE TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE
 LICENSE AGREEMENT, NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND
 CONDITIONS WITH REGARD TO THE SOFTWARE, WHETHER EXPRESS, IMPLIED
 OR STATUTORY, INCLUDING WITHOUT LIMITATION ALL WARRANTIES AND
 CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 TITLE AND NON-INFRINGEMENT.
 
 Copyright (c) 1995-2015 NetCracker Technology Corp.
 
 All Rights Reserved.
*/

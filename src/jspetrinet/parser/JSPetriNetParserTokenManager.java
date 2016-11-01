/* JSPetriNetParserTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. JSPetriNetParserTokenManager.java */
package jspetrinet.parser;
import jspetrinet.ast.*;
import jspetrinet.exception.*;
import jspetrinet.petri.*;
import jspetrinet.dist.*;

/** Token Manager. */
@SuppressWarnings("unused")public class JSPetriNetParserTokenManager implements JSPetriNetParserConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x40000008L) != 0L)
            return 0;
         if ((active0 & 0x20000L) != 0L)
         {
            jjmatchedKind = 41;
            return 11;
         }
         if ((active0 & 0xdffc0L) != 0L)
         {
            jjmatchedKind = 41;
            return 21;
         }
         return -1;
      case 1:
         if ((active0 & 0x20000L) != 0L)
            return 21;
         if ((active0 & 0xdffc0L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 1;
            return 21;
         }
         return -1;
      case 2:
         if ((active0 & 0x9e040L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 41;
               jjmatchedPos = 2;
            }
            return 21;
         }
         if ((active0 & 0x41f80L) != 0L)
            return 21;
         return -1;
      case 3:
         if ((active0 & 0x10c40L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 3;
            return 21;
         }
         if ((active0 & 0x8e000L) != 0L)
            return 21;
         return -1;
      case 4:
         if ((active0 & 0x40L) != 0L)
            return 21;
         if ((active0 & 0x10c00L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 4;
            return 21;
         }
         return -1;
      case 5:
         if ((active0 & 0xc00L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 5;
            return 21;
         }
         if ((active0 & 0x10000L) != 0L)
            return 21;
         return -1;
      case 6:
         if ((active0 & 0xc00L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 6;
            return 21;
         }
         return -1;
      case 7:
         if ((active0 & 0x800L) != 0L)
            return 21;
         if ((active0 & 0x400L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 7;
            return 21;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 34;
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      case 35:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 37:
         return jjStopAtPos(0, 31);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 40:
         return jjStopAtPos(0, 44);
      case 41:
         return jjStopAtPos(0, 45);
      case 42:
         return jjStopAtPos(0, 29);
      case 43:
         return jjStopAtPos(0, 27);
      case 44:
         return jjStopAtPos(0, 48);
      case 45:
         return jjStopAtPos(0, 28);
      case 47:
         jjmatchedKind = 30;
         return jjMoveStringLiteralDfa1_0(0x8L);
      case 58:
         return jjMoveStringLiteralDfa1_0(0x4000000000000L);
      case 59:
         return jjStopAtPos(0, 47);
      case 60:
         jjmatchedKind = 38;
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 61:
         jjmatchedKind = 49;
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 62:
         jjmatchedKind = 37;
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 103:
         return jjMoveStringLiteralDfa1_0(0xe00L);
      case 104:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x12100L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 123:
         return jjStopAtPos(0, 20);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 125:
         return jjStopAtPos(0, 21);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 35:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 42);
         break;
      case 38:
         if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(1, 33);
         break;
      case 42:
         if ((active0 & 0x8L) != 0L)
            return jjStopAtPos(1, 3);
         break;
      case 61:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 35);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         else if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 39);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(1, 40);
         else if ((active0 & 0x4000000000000L) != 0L)
            return jjStopAtPos(1, 50);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x8e000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x40e00L);
      case 102:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      case 111:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(1, 17, 21);
         break;
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x80L);
      case 124:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      case 99:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(2, 12, 21);
         break;
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 109:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(2, 8, 21);
         break;
      case 110:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 9;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0xc00L);
      case 112:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(2, 7, 21);
         break;
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x8e000L);
      case 116:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(2, 18, 21);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 46:
         return jjMoveStringLiteralDfa4_0(active0, 0xc00L);
      case 99:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 21);
         else if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 14, 21);
         else if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(3, 15, 21);
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      case 107:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 19, 21);
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x400L);
      case 101:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(4, 6, 21);
         break;
      case 115:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x800L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(5, 16, 21);
         break;
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 111:
         return jjMoveStringLiteralDfa6_0(active0, 0x400L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x800L);
      case 110:
         return jjMoveStringLiteralDfa7_0(active0, 0x400L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 102:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(7, 11, 21);
         break;
      case 115:
         return jjMoveStringLiteralDfa8_0(active0, 0x400L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 116:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(8, 10, 21);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 41;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if ((0x2400L & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                  }
                  else if (curChar == 34)
                     { jjCheckNAdd(18); }
                  else if (curChar == 46)
                     jjstateSet[jjnewStateCnt++] = 4;
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 0;
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 11:
               case 21:
                  if ((0x3ff400000000000L & l) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  { jjCheckNAdd(21); }
                  break;
               case 0:
                  if (curChar != 47)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(1); }
                  break;
               case 1:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(1); }
                  break;
               case 3:
                  if (curChar == 46)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAddStates(3, 5); }
                  break;
               case 6:
                  if ((0x280000000000L & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAdd(7); }
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAdd(7); }
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjCheckNAddStates(6, 9); }
                  break;
               case 17:
                  if (curChar == 34)
                     { jjCheckNAdd(18); }
                  break;
               case 18:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(18, 19); }
                  break;
               case 19:
                  if (curChar == 34 && kind > 26)
                     kind = 26;
                  break;
               case 22:
                  if (curChar == 10 && kind > 46)
                     kind = 46;
                  break;
               case 23:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if ((0x2400L & l) != 0L && kind > 46)
                     kind = 46;
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 39:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(39, 3); }
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  { jjCheckNAdd(40); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 41)
                        kind = 41;
                     { jjCheckNAdd(21); }
                  }
                  if (curChar == 70)
                     { jjAddStates(10, 11); }
                  else if (curChar == 84)
                     { jjAddStates(12, 13); }
                  else if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 15;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 11:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 41)
                        kind = 41;
                     { jjCheckNAdd(21); }
                  }
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 1:
                  if (kind > 22)
                     kind = 22;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 5:
                  if ((0x2000000020L & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  { jjAddStates(14, 15); }
                  break;
               case 9:
                  if (curChar == 101 && kind > 25)
                     kind = 25;
                  break;
               case 10:
               case 26:
                  if (curChar == 117)
                     { jjCheckNAdd(9); }
                  break;
               case 12:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 13:
               case 32:
                  if (curChar == 115)
                     { jjCheckNAdd(9); }
                  break;
               case 14:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 15:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 16:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 18:
                  { jjAddStates(16, 17); }
                  break;
               case 20:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  { jjCheckNAdd(21); }
                  break;
               case 21:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  { jjCheckNAdd(21); }
                  break;
               case 25:
                  if (curChar == 84)
                     { jjAddStates(12, 13); }
                  break;
               case 27:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 28:
                  if (curChar == 69 && kind > 25)
                     kind = 25;
                  break;
               case 29:
                  if (curChar == 85)
                     { jjCheckNAdd(28); }
                  break;
               case 30:
                  if (curChar == 82)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 70)
                     { jjAddStates(10, 11); }
                  break;
               case 33:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 34:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 35:
                  if (curChar == 83)
                     { jjCheckNAdd(28); }
                  break;
               case 36:
                  if (curChar == 76)
                     jjstateSet[jjnewStateCnt++] = 35;
                  break;
               case 37:
                  if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 36;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 18:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(16, 17); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 41 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_1(){
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x10L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_1(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x10L) != 0L)
            return jjStopAtPos(1, 4);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   39, 3, 40, 5, 6, 8, 5, 6, 7, 8, 34, 37, 27, 30, 6, 7, 
   18, 19, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\160\154\141\143\145", "\145\170\160", 
"\151\155\155", "\147\145\156", "\147\145\156\56\143\157\156\163\164", 
"\147\145\156\56\165\156\151\146", "\141\162\143", "\151\141\162\143", "\157\141\162\143", "\150\141\162\143", 
"\151\146\145\154\163\145", "\164\157", "\156\145\164", "\155\141\162\153", "\173", "\175", null, null, 
null, null, null, "\53", "\55", "\52", "\57", "\45", "\174\174", "\46\46", "\41", 
"\75\75", "\41\75", "\76", "\74", "\76\75", "\74\75", null, "\43\43", "\43", "\50", 
"\51", null, "\73", "\54", "\75", "\72\75", };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100000200L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 5)
         {
            jjmatchedKind = 5;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public JSPetriNetParserTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public JSPetriNetParserTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 41; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "WithinComment",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, 
};
static final long[] jjtoToken = {
   0x7ffffffffffc1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
static final long[] jjtoMore = {
   0x20L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[41];
    private final int[] jjstateSet = new int[2 * 41];

    
    protected char curChar;
}

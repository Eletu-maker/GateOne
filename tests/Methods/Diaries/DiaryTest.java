package Methods.Diaries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    @Test
    public void Test_Lock(){
        Diary diary = new Diary("usman","password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.lockDiary("password");
        assertTrue(diary.isLocked());

    }

    @Test
    public void test_Entry_exist(){
        Diary diary = new Diary("usman","password");
        diary.unlockDiary("password");
        Entry entry = new Entry("1","i love usamn","he is a goat, he goat");
        diary.createEntry(entry);
        assertEquals(1,diary.getEntries().size());
    }

    @Test
    public void test_Multiply_Entry_exist(){
        Diary diary = new Diary("usman","password");
        diary.unlockDiary("password");
        Entry entry1 = new Entry("1","title1","gist1");
        Entry entry2 = new Entry("2","title2","gist2");
        Entry entry3 = new Entry("3","title3","gist3");
        diary.createEntry(entry1);
        diary.createEntry(entry2);
        assertEquals(2,diary.getEntries().size());
        diary.createEntry(entry3);
        assertEquals(3,diary.getEntries().size());
    }

    @Test
    public void test_that_delete_Entry(){
        Diary diary = new Diary("usman","password");
        diary.unlockDiary("password");
        Entry entry1 = new Entry("1","title1","gist1");
        Entry entry2 = new Entry("2","title2","gist2");
        Entry entry3 = new Entry("3","title3","gist3");
        diary.createEntry(entry1);
        diary.createEntry(entry2);
        diary.createEntry(entry3);
        diary.deleteEntry(entry2);
        assertEquals(2,diary.getEntries().size());
    }

    @Test
    public void test_that_find_by_id_works(){
        Diary diary = new Diary("usman","password");
          diary.unlockDiary("password");
        Entry entry1 = new Entry("1","title1","gist1");
        Entry entry2 = new Entry("2","title2","gist2");
        Entry entry3 = new Entry("3","title3","gist3");
        diary.createEntry(entry1);
        diary.createEntry(entry2);
        diary.createEntry(entry3);

        assertEquals(entry2,diary.findEntryById("2"));
    }


    @Test
    public void test_that_diaries_works(){

        Diaries diaries =new Diaries();
        diaries.add("usman","password");
        diaries.add("kored","password");
        diaries.add("lanky","password");


        assertEquals(3,diaries.getDiaries().size());
    }

    @Test
    public void test_that_findByUsername_work(){
        Diaries diaries =new Diaries();
        diaries.add("usman","password");
        diaries.add("kored","password");
        diaries.add("lanky","password");

        assertEquals("usman, locked: true",diaries.findByUsername("usman").toString());
    }

    @Test
    public void test_that_delete_work(){
        Diaries diaries =new Diaries();
        diaries.add("usman","password");
        diaries.add("kored","password");
        diaries.add("lanky","password");
        Diary diary = diaries.findByUsername("usman");
        diaries.delete(diary);


        assertNull(diaries.findByUsername("usman"));
    }



}
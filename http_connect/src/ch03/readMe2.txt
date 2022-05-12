
parsing 

Student student = gson.fromJson(str, Student.class)


//3 . 배열 타입으로 변환 방법
Todo[] todos = new Gson().fromJson(reader, Todo[].class);

// ArrayList 타입으로 변환
Type userListType = new TypeToken<ArrayList<Todo>>() {
}.getType();

ArrayList<Todo> todoArrayList = new Gson().fromJson(reader, userListType);

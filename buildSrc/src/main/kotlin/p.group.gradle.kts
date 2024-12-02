plugins{

}

if (parent != null) {
    group = "${parent!!.group}.${parent!!.name}"
}
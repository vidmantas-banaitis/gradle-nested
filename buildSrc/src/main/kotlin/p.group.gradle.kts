plugins{
    base
}

if (parent != null) {
    group = "${parent!!.group}.${parent!!.name}"
}
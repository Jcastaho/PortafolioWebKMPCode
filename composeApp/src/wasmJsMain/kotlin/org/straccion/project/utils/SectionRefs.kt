package org.straccion.project.utils

object SectionRefs {
    private val _sectionOffsets = mutableMapOf<String, Float>()

    fun setOffset(section: String, position: Float) {
        if (!_sectionOffsets.containsKey(section)) {
            _sectionOffsets[section] = position
        }
    }

    fun getOffset(section: String): Float? = _sectionOffsets[section]
}
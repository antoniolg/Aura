# Instrucciones para el Agente

## Checklist Pre-Commit
Cada vez que se cree código o se realice una modificación, se deben seguir estos pasos antes de hacer un commit:

1. **Compilación**: Ejecutar la tarea `:app:compileDebugKotlin` para asegurar que el código es válido.
2. **Análisis de Lint**: Realizar un `analyze_file` de todos los ficheros modificados o creados.
3. **Calidad de Código**: Asegurarse de que no se introducen nuevos warnings ni errores.
4. **Commit**: Crear un commit con los cambios usando la skill de committer (un commit por funcionalidad o cambio lógico).
5. **Push**: **No** realizar push a menos que se indique específicamente.

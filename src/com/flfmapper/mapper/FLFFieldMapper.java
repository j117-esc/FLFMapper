package com.flfmapper.mapper;

import com.flfmapper.entity.FLFFieldMetaData;

/**Defines common methods for mapping POJO fields into strings and vice versa.
 * @author Jimmy
 *
 */
public interface FLFFieldMapper {
	/**Checks if the readMethodReturnType param is handled by the mapper class.
	 * @param readMethodReturnType
	 * @return
	 */
	public boolean isReturnTypeHandled(Class<?> readMethodReturnType);
	
	
	/**Maps the column text from a fixed length file field into a POJO field return type.
	 * @param <T>
	 * @param <F>
	 * @param flfFieldMetaData
	 * @return
	 */
	public <T,F> F mapToType(FLFFieldMetaData<T> flfFieldMetaData);
	
	/**Maps a POJO field into a fixed length file field.
	 * @param <T>
	 * @param flfFieldMetaData
	 * @return
	 */
	public <T> String maptToString(FLFFieldMetaData<T> flfFieldMetaData);
}
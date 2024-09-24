import React from 'react';
import { useSearchParams } from 'react-router-dom';

export default function ListPage() {

	const [queryParams] = useSearchParams();

	const page = queryParams.get('page') ? parseInt(queryParams.get('page')) : 1
	// queryParams.get('page')가 존재하면 인트로 변환해서 리턴, 없으면 1 리턴
	const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 10
	// queryParams.get('size')가 존재하면 인트로 변환해서 리턴, 없으면 10 리턴

	
	
	return (
		<div className="p-4 w-full bg-orange-200 ">
			<div className="text-3xl font-extrabold">
				Todo List Page Component --- {page} --- {size}
			</div>
		</div>

	)
}
